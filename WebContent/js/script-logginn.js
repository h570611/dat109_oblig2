"use strict";


window.onload = () => {

    const mobil = document.getElementById('mobil');
    const passord = document.getElementById('passord');


    mobil.addEventListener('input', onChangeMobil);
    passord.addEventListener('input', onChangePassord);


    mobil.title = "Mobilnummeret ditt";
    passord.title = "Passordet ditt";
}


let validMobil = true;
let validPassord = true;

AllValid();


function onChangeMobil(event) {
    const mobil = document.getElementById('mobil');
    const input = event.target.value;
    if (event.target.value.length != 8 ){
        mobil.setAttribute("style", "border-color: red")

    } else{
        mobil.setAttribute("style", "border-color: green")
        validMobil = true;
    }
    AllValid();
}


function onChangePassord(event) {
    const passord = document.getElementById('passord');
    const input = event.target.value;

    if (input.length < 5 ){
        passord.setAttribute("style", "border-color: red")
    } else{
            passord.setAttribute("style", "border-color: green")
            validPassord = true;
    }

    AllValid();
}


function AllValid() {
    if( validPassord && validMobil ){
        document.getElementById("loggInnButton").disabled = false;
    }else{
        document.getElementById("loggInnButton").disabled = true;
    }
}
