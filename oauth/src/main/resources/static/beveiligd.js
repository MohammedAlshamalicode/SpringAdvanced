"use strict";
const response = await fetch("user");
const user = await response.json();
document.getElementById("login").innerText = user.login;
document.getElementById("name").innerText = user.name;