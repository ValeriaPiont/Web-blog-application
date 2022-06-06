function send() {
    let object = {
        "username": document.getElementById("username").value,
        "text": document.getElementById("text_snippet").value
    };
    console.log(object);
    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/my_blog/v1/posts/api', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    window.location.reload();
}