function showComments() {
    fetch('https://jsonplaceholder.typicode.com/comments?postId=' + this.value)
    .then(resp => resp.json())
    .then(comments => {
        let commentsDiv = document.getElementById("postComment" + comments[0].postId);
        commentsDiv.innerHTML = "";
        comments.forEach(comment => {
            let userInfo = document.createElement("h2");
            userInfo.innerText = comment.name + "(" + comment.email + ")";
            let commentBody = document.createElement("p");
            commentBody.innerText = comment.body;
            let commentDiv = document.createElement("div");
            commentDiv.append(userInfo);
            commentDiv.append(commentBody);
            commentDiv.style.border = "solid 1px";
            commentDiv.style.margin = "20px";
            commentsDiv.append(commentDiv);
        });
        commentsDiv.style.display = "block";
        commentsDiv.style.border = "solid 1px";
        // commentsDiv.style.margin = "20px";
    })
}

let dataCollector = (() => {
    let main_url = "http://jsonplaceholder.typicode.com";

    function collectUser(userId) {
        fetch(main_url + "/users/" + userId)
            .then(resp => resp.json())
            .then(user => {
                let nameSpan = document.createElement("span");
                nameSpan.innerText = "Name : " + user.name;
                let emailSpan = document.createElement("span");
                emailSpan.innerText = "Email : " + user.email;
                let phoneSpan = document.createElement("span");
                phoneSpan.innerText = "Phone : " + user.phone;
                let userInfo = window.document.getElementById("userInfo");
                userInfo.innerHTML = "";
                userInfo.append(nameSpan);
                userInfo.append(document.createElement("br"));
                userInfo.append(emailSpan);
                userInfo.append(document.createElement("br"));
                userInfo.append(phoneSpan);
                userInfo.style.border = "solid 1px";
                userInfo.style.margin = "20px";
            })
            .catch((error) => {
                console.error('Error:', error);
            });

    };

    function collectUserPosts(userId) {
        fetch(main_url + "/posts?userId=" + userId)
            .then(resp => resp.json())
            .then(posts => {
                let postsDiv = document.getElementById("posts");
                postsDiv.innerHTML = "";
                postsDiv.style.border = "solid 1px";
                posts.forEach(post => {
                    let commentDiv = document.createElement("div");
                    commentDiv.id = "postComment" + post.id;
                    commentDiv.style.display = "None";
                    let commentButton = document.createElement("button");
                    commentButton.id = "showComment" + post.id;
                    commentButton.value = post.id;
                    commentButton.innerText = "Show comments";
                    commentButton.onclick = showComments;
                    let postEl = document.createElement("div");
                    postEl.id = "postId" + post.id;
                    let postTitle = document.createElement("h1");
                    postTitle.innerText = post.title;
                    let postBody = document.createElement("p");
                    postBody.innerText = post.body;
                    postEl.append(postTitle);
                    postEl.append(postBody);
                    postEl.append(commentButton);
                    postEl.append(commentDiv);
                    postEl.style.border = "solid 1px";
                    postEl.style.margin = "10px";
                    postsDiv.append(postEl);
                });
            })
            .catch((error) => {
                console.error('Error:', error);
            });

    };

    return {
        collectUser,
        collectUserPosts
    }
})();

function getInfo() {
    let userId = parseInt(document.getElementsByName("userId")[0].value);
    console.log(userId);
    dataCollector.collectUser(userId);
    dataCollector.collectUserPosts(userId);
}

window.onload = (() => {
    document.getElementById('getUserBtn').onclick = getInfo;
})