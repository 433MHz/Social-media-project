var loginDiv = document.getElementById("loginDiv");


function ShowFullLogin(){
    loginDiv.style.width = "100%";
    loginDiv.style.height = "30vh";
    loginDiv.style.backgroundColor = "rgb(50, 146, 255)";
    document.getElementById("loginButton").setAttribute("onclick","HideFullLogin()");
    console.log(loginDiv);
}

function HideFullLogin(){
    loginDiv.style.width = "";
    loginDiv.style.height = "";
    loginDiv.style.backgroundColor = "";
    document.getElementById("loginButton").setAttribute("onclick","ShowFullLogin()");
}

function ShowFullRegister(){

}

function HideFullRegister(){

}