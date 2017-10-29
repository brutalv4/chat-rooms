$(document).ready(function () {
    var listedMessages = [];

    updateClock();
    updateMessages();

    function updateMessages() {
        // $('.msg').remove();

        $.getJSON("/get-messages?chatRoomId=" + chatRoomId, function (messages) {
            $.each(messages, function (key, message) {
                if (listedMessages[message.id] === undefined) {
                    var username = message.user.name;
                    var dateSent = parseDateTime(message.dateSent);
                    var content = message.content;

                    listMessage(
                        username,
                        dateSent,
                        content
                    )

                    listedMessages[message.id] = message;

                    var msgDiv = $('.msg-wrap');
                    msgDiv.scrollTop = msgDiv.height;
                }
            })
        });
    }

    $('.send-message-btn').click(function () {
        var content = $('.send-message').val();
        $.post(
            "/send-message",
            {
                chatRoomId: chatRoomId,
                content: content
            },
            updateMessages()
        );
    });

    function parseDateTime(jsonDateTime) {
        var date = jsonDateTime.date;
        var time = jsonDateTime.time;
        return new Date(
            date.year,
            date.month - 1,
            date.day,
            time.hour,
            time.minute,
            time.second
        );
    }

    function listMessage(username, datesent, content, today) {
        // <%--<div class="alert alert-info msg-date">--%>
        // <%--<strong>Today</strong>--%>
        // <%--</div>--%>

        // creating message div
        var messageDiv = document.createElement('div');
        messageDiv.className = 'media msg';
        $('.msg-wrap')[0].appendChild(messageDiv);

        // appending a element
        var aElement = document.createElement('a');
        aElement.className = 'pull-left';
        aElement.href = '#';
        messageDiv.appendChild(aElement);

        // appending avatar
        var userAvatar = document.createElement('img');
        userAvatar.className = 'media-object';
        userAvatar.data = 'holder.js/64x64';
        userAvatar.alt = '64x64';
        userAvatar.style = 'width: 32px; height: 32px;';
        userAvatar.src = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAACqUlEQVR4Xu2Y60tiURTFl48STFJMwkQjUTDtixq+Av93P6iBJFTgg1JL8QWBGT4QfDX7gDIyNE3nEBO6D0Rh9+5z9rprr19dTa/XW2KHl4YFYAfwCHAG7HAGgkOQKcAUYAowBZgCO6wAY5AxyBhkDDIGdxgC/M8QY5AxyBhkDDIGGYM7rIAyBgeDAYrFIkajEYxGIwKBAA4PDzckpd+322243W54PJ5P5f6Omh9tqiTAfD5HNpuFVqvFyckJms0m9vf3EY/H1/u9vb0hn89jsVj8kwDfUfNviisJ8PLygru7O4TDYVgsFtDh9Xo9NBrNes9cLgeTybThgKenJ1SrVXGf1WoVDup2u4jFYhiPx1I1P7XVBxcoCVCr1UBfTqcTrVYLe3t7OD8/x/HxsdiOPqNGo9Eo0un02gHkBhJmuVzC7/fj5uYGXq8XZ2dnop5Mzf8iwMPDAxqNBmw2GxwOBx4fHzGdTpFMJkVzNB7UGAmSSqU2RoDmnETQ6XQiOyKRiHCOSk0ZEZQcUKlU8Pz8LA5vNptRr9eFCJQBFHq//szG5eWlGA1ywOnpqQhBapoWPfl+vw+fzweXyyU+U635VRGUBOh0OigUCggGg8IFK/teXV3h/v4ew+Hwj/OQU4gUq/w4ODgQrkkkEmKEVGp+tXm6XkkAOngmk4HBYBAjQA6gEKRmyOL05GnR99vbW9jtdjEGdP319bUIR8oA+pnG5OLiQoghU5OElFlKAtCGr6+vKJfLmEwm64aosd/XbDbbyIBSqSSeNKU+HXzlnFAohKOjI6maMs0rO0B20590n7IDflIzMmdhAfiNEL8R4jdC/EZIJj235R6mAFOAKcAUYApsS6LL9MEUYAowBZgCTAGZ9NyWe5gCTAGmAFOAKbAtiS7TB1Ng1ynwDkxRe58vH3FfAAAAAElFTkSuQmCC';
        aElement.appendChild(userAvatar);

        // appending media body div
        var mediaBodyDiv = document.createElement('div');
        mediaBodyDiv.className = 'media-body';
        messageDiv.appendChild(mediaBodyDiv);

        // appending date sent
        var dateSentElement = document.createElement('small');
        dateSentElement.className = 'pull-right time';

        dateSentElement.innerHTML = new Intl.DateTimeFormat(
            "en-US",
            {
                // weekday: "long",
                year: "numeric",
                month: "long",
                day: "numeric",
                hour: "numeric",
                minute: "numeric",
                second: "numeric",
                hour12: false
            }
        ).format(datesent);

        mediaBodyDiv.appendChild(dateSentElement);

        var faFaClock = document.createElement('i');
        faFaClock.className = 'fa fa-clock-o';
        dateSentElement.appendChild(faFaClock);

        // appending user name
        var userNameElement = document.createElement('h5');
        userNameElement.className = 'media-heading';
        userNameElement.innerHTML = username;
        mediaBodyDiv.appendChild(userNameElement);

        // appending content
        var messageContentElement = document.createElement('small');
        messageContentElement.className = 'col-lg-10';
        messageContentElement.innerHTML = content;
        mediaBodyDiv.appendChild(messageContentElement);
    }

    function updateClock() {
        $('#current-time')[0].innerHTML =
            new Intl.DateTimeFormat(
                "en-US",
                {
                    weekday: "long",
                    year: "numeric",
                    month: "long",
                    day: "numeric",
                    hour: "numeric",
                    minute: "numeric",
                    second: "numeric",
                    hour12: false
                }
            ).format(new Date());
    }

    setInterval(updateClock, 1000);
    setInterval(updateMessages, 3000)
});
