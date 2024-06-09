const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/connect'
});
let roomIdx;
let teacherIdx;
let teacherName;
let title;
let intro;
let commentYN;
let scoreYN;
let continueYN;
let rankYN;
let bMusicYN;
let eMusicYN;
let quizIdx;

let quizMemberIdx;
let sName;
let sPassword;
let sImgUrl;
let sCorrectCount;
let sAnswerCount;
let sTotalScore;


stompClient.onConnect = (frame) => {
    console.log('Connected: ' + frame);
    console.log('code = /sub/quizgame/'+roomIdx);
    stompClient.subscribe('/sub/quizgame/'+roomIdx, (memberDTO) => {
        showMember(memberDTO.body);
    });

};

stompClient.onDisconnect = (frame) =>{
    stompClient.deactivate();
    console.log("Auto Disconnected");
}

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function openRoom(url) {
    $.ajax({
        url: '/game/create',
        type: 'post',
        contentType: 'application/x-www-form-urlencoded',
        dataType: 'json',
        data: {
            quizIdx:1
        },

        success: function(data) {
            roomIdx= data;
            console.log("ajax roomIdx ="+roomIdx);
            window.open(url+"?roomIdx="+roomIdx,"_blank","menubar=no,toolbar=no,titlebar=no")
        },
        error: function() {
            alert("서버와의 통신 중 오류가 발생했습니다.");
        }
    });
}
function roomConnect(){
    roomIdx = $("#roomIdx").val();
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    console.log("Disconnected");
}

function showMember(memberDTO) {
    console.log("show memberDTO" + memberDTO);
    let member = JSON.parse(memberDTO);
    console.log(member);
    $("#user-list").append(`<div className='user-item'>
    <div className='user-img'>
        <img src=${member.simgUrl} alt=''/>
        </div>
    <p className='name'>${member.sname}</p>
    <button type='button' className='btn-del'><i className='ic-user-del'></i><span className='for-a11y'>삭제</span>
    </button>
</div>`);
}

function startQuiz(){
    $.ajax({
        url: '/game/start',
        type: 'post',
        contentType: 'application/x-www-form-urlencoded',
        dataType: 'json',
        data: {
            roomIdx:roomIdx
        },

        success: function(data) {
            roomIdx= data;
            console.log("ajax roomIdx ="+roomIdx);
        },
        error: function() {
            alert("서버와의 통신 중 오류가 발생했습니다.");
        }
    });
}

function endQuiz(){
}