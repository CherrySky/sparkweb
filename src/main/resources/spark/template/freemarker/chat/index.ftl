<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Chat">
<body>
<div class="form-inline">
    <div id="container">
        <input type="text" class="form-control" id="message" placeholder="Type your message">
        <button type="submit" class="btn btn-primary" id="send">Send</button>
    </div>
    </div>
    <ul id="userlist"> <!-- Built by JS --> </ul>
    <div id="chat">    <!-- Built by JS --> </div>
    <script src="../js/websocketDemo.js"></script>
</body>
</@layout.masterTemplate>