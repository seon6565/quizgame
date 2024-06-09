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
        startEnd(memberDTO.body);
    });
    // stompClient.publish({
    //     destination: "/pub/quizgame",
    //     body: JSON.stringify({"quizMemberIdx":quizMemberIdx,'roomIdx':roomIdx,"regDate":null,"sPassword":sPassword,"sCorrectCount":sCorrectCount,"sImgUrl":sImgUrl,"sName":sName,"sTotalScore":sTotalScore})
    // });
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


function disconnect() {
    stompClient.deactivate();
    console.log("Disconnected");
}

function codeEnter(){
    roomIdx = $("#roomIdx").val();
    console.log("roomIdx = "+roomIdx);
    $("#form-box").html(`
    <div class="form-group">
        <div class="form-title">
            <h3 class="title">나도 참여할래요.</h3>
        </div>
        <div class="form-item">
            <div class="input-wrap">
                <label for="input-name" class="input-label-icon"><i class="ic-name"></i></label>
                <input type="text" id="sName" class="input-line" placeholder="이름">
            </div>
            <p class="error-text">
                <i class="ic-warning"></i>
                사용 중이에요. 다른 이름을 넣어주세요
            </p>
        </div>
        <div class="form-item">
            <div class="input-wrap">
                <label for="input-pw" class="input-label-icon"><i class="ic-password"></i></label>
                <input type="password" id="sPassword" class="input-line" placeholder="참여자 비밀번호">
            </div>
            <p class="guide-text">4자리 비밀번호를 입력해주세요.</p>
        </div>
    </div><div class="form-btn">
            <button onclick="namePwdEnter()" type="button" class="btn-type-black"><span class="btn-txt">시작하기</span></button>
        </div>`);
}
function namePwdEnter(){
    sName = $("#sName").val();
    sPassword = $("#sPassword").val();
    console.log("sName = "+sName);
    console.log("sPassword = "+sPassword);
    $("#form-box").html(`<main class="content-area ready">
        <p class="ready-txt3">어떤 친구로 참여할까요?</p>
        <div class="character-list">
            <div class="character-group">
                <p class="character-name">1번 <span class="name">항목</span></p>
                <div class="character-item color1">
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character1-1" value="/images/character/character1-1.png">
                        <label for="character1"><img src="/images/character/character1-1.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character1-2" value="/images/character/character1-2.png">
                        <label for="character2"><img src="/images/character/character1-2.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character1-3" value="/images/character/character1-3.png">
                        <label for="character3"><img src="/images/character/character1-3.png" alt=""></label>
                    </div>
                </div>
            </div>
            <div class="character-group">
                <p class="character-name">2번 <span class="name">항목</span></p>
                <div class="character-item color2">
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character2-1" value="/images/character/character2-1.png">
                        <label for="character1-2"><img src="/images/character/character2-1.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character2-2" value="/images/character/character2-2.png">
                        <label for="character2-2"><img src="/images/character/character2-2.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character2-3" value="/images/character/character2-3.png">
                        <label for="character3-2"><img src="/images/character/character2-3.png" alt=""></label>
                    </div>
                </div>
            </div>
            <div class="character-group">
                <p class="character-name">3번 <span class="name">항목</span></p>
                <div class="character-item color3">
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character3-1" value="/images/character/character3-1.png">
                        <label for="character1-3"><img src="/images/character/character3-1.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character3-2" value="/images/character/character3-2.png">
                        <label for="character2-3"><img src="/images/character/character3-2.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character3-3" value="/images/character/character3-3.png">
                        <label for="character3-3"><img src="/images/character/character3-3.png" alt=""></label>
                    </div>
                </div>
            </div>
            <div class="character-group">
                <p class="character-name">4번 <span class="name">항목</span></p>
                <div class="character-item color4">
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character4-1" value="/images/character/character4-1.png">
                        <label for="character1-4"><img src="/images/character/character4-1.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character4-2" value="/images/character/character4-2.png">
                        <label for="character2-4"><img src="/images/character/character4-2.png" alt=""></label>
                    </div>
                    <div class="character-choice">
                        <input type="radio" class="character-radio" name="sImgUrl" id="character4-3" value="/images/character/character4-3.png">
                        <label for="character3-4"><img src="/images/character/character4-3.png" alt=""></label>
                    </div>
                </div>
            </div>
        </div>
        <div class="btn-a-center">
            <button onclick="startWait()" type="button" class="btn-type-black">골랐어요!</button>
        </div>
    </main>`);
}

function startWait(){
    sImgUrl = document.querySelector('[name="sImgUrl"]:checked').value;
    console.log("sImgUrl = "+sImgUrl);

    $.ajax({
        url: '/game/joinmember',
        type: 'post',
        contentType: 'application/x-www-form-urlencoded',
        dataType: 'json',
        data: {
            roomIdx: roomIdx,
            sName: sName,
            sPassword: sPassword,
            sImgUrl: sImgUrl,
            sCorrectCount: 0,
            sAnswerCount: 0,
            sTotalScore: 0,
        },

        success: function(data) {
            $("#form-box").html(`
            <main class="content-area ready">
                <p class="ready-txt1">선생님이 시작하기 버튼을 누르면 <br>바로 풀이가 시작돼요.</p>
                <div class="img-box color2"><img src=${sImgUrl} alt=""></div>
                <p class="ready-txt2"><span class="m-block">${sName}님이</span> 입장하였습니다.</p>
            </main>
            `)
            stompClient.activate();

        },
        error: function() {
            alert("서버와의 통신 중 오류가 발생했습니다.");
        }
    });
}

function startEnd(memberDTO) {
    let member = JSON.parse(memberDTO);
    if(member.startEnd=="start"){
        oxRendering();
    }
    else if(member.startEnd=="end"){
        //종료레이아웃
        stompClient.deactivate();
    }
}
