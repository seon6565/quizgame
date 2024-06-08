const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/connect'
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    let roomIdx = $("#roomIdx").val();
    console.log('code = /sub/quizgame/'+roomIdx);
    stompClient.subscribe('/sub/quizgame/'+roomIdx, (greeting) => {
        showGreeting(greeting.body);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    let roomIdx = $("#roomIdx").val();
    let sName = $("#sName").val();
    console.log("destination"+"/pub/quizgame"+roomIdx);
    console.log("json: "+JSON.stringify({'quizMemberIdx':"0",'roomIdx':roomIdx,'sName': $("#sName").val()}));
    stompClient.publish({
        destination: "/pub/quizgame",
        body: JSON.stringify({'quizMemberIdx':"4",'roomIdx':roomIdx,"regDate":null,"spassword":null,"scorrectCount":0,"simgUrl":null,"sname":sName,"stotalScore":0})
    });
}

function showGreeting(message) {
    console.log("result message" +message);
    $("#chatlist").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#send" ).click(() => sendName());
});