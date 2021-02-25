var loginDiv = document.getElementById("loginDiv");
var registerDiv = document.getElementById("registerDiv");

function ShowFullLogin(){
    HideFullRegister();
    document.getElementById("loginDiv").innerHTML = BuildHTMLCode();
    loginDiv.setAttribute("id", "loginDiv2");
    function BuildHTMLCode(){
        var HTMLCode = "";
        HTMLCode = HTMLCode + "<input type=\"text\" placeholder=\"Login\"><br>";
        HTMLCode = HTMLCode + "<input type=\"text\" placeholder=\"Hasło\"><br>";
        HTMLCode = HTMLCode + "<input type=\"button\" value=\"Zaloguj\"><br>";
        return HTMLCode;
    }
}

function HideFullLogin(){
    loginDiv.setAttribute("id", "loginDiv");
    loginDiv.setAttribute("onmouseout", "");
    loginDiv.innerHTML = "<input id=\"loginButton\" type=\"button\" value=\"Zaloguj\" onclick=\"ShowFullLogin()\"><br>";
}

function ShowFullRegister(){
    HideFullLogin();
    document.getElementById("registerDiv").innerHTML = BuildHTMLCode();
    registerDiv.setAttribute("id", "registerDiv2");
    function BuildHTMLCode(){
        var HTMLCode = "";
        HTMLCode = HTMLCode + "<input type=\"text\" placeholder=\"Login\"><br>";
        HTMLCode = HTMLCode + "<input type=\"text\" placeholder=\"Hasło\"><br>";
        HTMLCode = HTMLCode + "<input type=\"text\" placeholder=\"Powtórz hasło\"><br>";
        HTMLCode = HTMLCode + "<input type=\"button\" value=\"Zarejestruj\"><br>";
        return HTMLCode;
    }
}

function HideFullRegister(){
    registerDiv.setAttribute("id", "registerDiv");
    registerDiv.innerHTML = "<input id=\"registerButton\" type=\"button\" value=\"Zarejestruj\" onclick=\"ShowFullRegister()\"><br>";
}