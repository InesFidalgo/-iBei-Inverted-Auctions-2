var websocket = null;
 
window.onload = function() { // URI = ws://10.16.0.165:8080/WebSocket/ws
    connect('ws://' + window.location.host + '/CRLDS/ws');
    document.getElementById("chat").focus();
}
 
function connect(host) { // connect to the host websocket
	console.log (host);
    if ('WebSocket' in window)
        websocket = new WebSocket("ws://localhost:8080/CRLSD/ws");
    else if ('MozWebSocket' in window)
        websocket = new MozWebSocket("ws://localhost:8080/CRLSD/ws");
    else {
        writeToHistory('Get a real browser which supports WebSocket.');
        return;
    }
 
    websocket.onopen    = onOpen; // set the event listeners below
    websocket.onclose   = onClose;
    websocket.onmessage = onMessage;
    websocket.onerror   = onError;
}
 
function onOpen(event) {
	websocket.send("login"); 
    writeToHistory('Connected to ' + window.location.host + '.');
    
}
 
function onClose(event) {
    //writeToHistory('WebSocket closed.');
    document.getElementById('chat').onkeydown = null;
}
 
function onMessage(message) { // print the received message
    var texto = message.data;
    console.log(message);
    if (texto.substr(0,11)==="notificacao" ||texto.substr(0,8)==="Mensagem"){
    	updatenoti(texto);
    }
    else if(texto.substr(0,6) === "Online"){
		updateOnlineUsers(texto);
	}
    else if (texto.substr (0,4)==="type"){
    	writeTonotificcacoesOf(texto);
    }
	else{
		writeToHistory(texto);
	}
    
}
 
function onError(event) {
    writeToHistory('WebSocket error (' + event.data + ').');
    document.getElementById('chat').onkeydown = null;
}
 
function doSend() {
    var message = document.getElementById('chat').value;
    if (message != '')
        websocket.send(message); // send the message
    document.getElementById('chat').value = '';
}
 
function writeToHistory(text) {
    var history = document.getElementById('history');
    var line = document.createElement('p');
    line.style.wordWrap = 'break-word';
    history.innerHTML = text;
    //history.appendChild(line);
    //history.value(line);
    history.scrollTop = history.scrollHeight;
}
function writeTonotificcacoesOf(text) {
    var history = document.getElementById('notiOF');
    var line = document.createElement('p');
    line.style.wordWrap = 'break-word';
    history.innerHTML = text;
    //history.appendChild(line);
    //history.value(line);
    history.scrollTop = history.scrollHeight;
}
 
 
function updateOnlineUsers(text) {
    var online = document.getElementById('online');
    online.style.wordWrap = 'break-word';
    online.innerHTML = text;
    online.style.textAlign = "center";
    online.scrollTop = online.scrollHeight;
}

function updatenoti(text) {
    var online = document.getElementById('noti');
    online.style.wordWrap = 'break-word';
    online.innerHTML = text;
    online.style.textAlign = "center";
    online.scrollTop = online.scrollHeight;
}