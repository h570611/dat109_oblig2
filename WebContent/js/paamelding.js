"use strict";


window.onload = () => {
    const fornavn = document.getElementById('fornavn');
    const etternavn = document.getElementById('etternavn');
    const mobil = document.getElementById('mobil');
    const passord = document.getElementById('passord');
    const repetertPassord = document.getElementById('passordRepetert');
    const kjonn = document.getElementById("kjonn");
    const kjonn1 = document.getElementById("kjonn1")


    fornavn.addEventListener('input', onChangeFornavn);
    etternavn.addEventListener('input', onChangeEtternavn);
    mobil.addEventListener('input', onChangeMobil);
    passord.addEventListener('input', onChangePassord);
    repetertPassord.addEventListener('input', onChangeRepetertPassord);
    kjonn.addEventListener('input', onChangeKjonn);
    kjonn1.addEventListener('input', onChangeKjonn1)
   // passord.addEventListener('input', onChangeRepetertPassord);

    fornavn.title= " Krav for fornavn : \n -Stor forbokstav  \n -Mellom 2 og 20 tegn"
    etternavn.title = "Krav for etternavn: \n -Stor forbokstav \n -Mellom 2 og 20 tegn \n -Ingen mellomrom";
    mobil.title = "Krav for mobilnummer: \n -Må være eit tal \n -Akkurat 8 tal";
    passord.title = "Krav for passord: \n -Må være minste 5 tegn";
    repetertPassord.title = "Krav for repetert passord: \n -Må være heilt likt det første passordet.";





}

let validFornavn = false;
let validEtternavn = false;
let validMobil = false;
let validPassord = false;
let validRepPassord = false;
let validKjonn = false;

AllValid();

function onChangeFornavn(event) {
    const feilFornavn = document.getElementById("feilFornavn")
    const fornavn = document.getElementById('fornavn');
    const input = event.target.value;
    if (input.length < 2  || input.length > 20 || input[0] !== input[0].toUpperCase()){
        fornavn.setAttribute("style", "border-color: red")
        feilFornavn.style.display = "initial"
    } else{
        fornavn.setAttribute("style", "border-color: green")
        feilFornavn.style.display = "none"
        validFornavn = true;
    }
    AllValid();
}

function onChangeEtternavn(event) {
    const feilEtternavn = document.getElementById("feilEtternavn")
    const etternavn = document.getElementById('etternavn');
    const input = event.target.value;
    if (event.target.value.length < 2 || input.length > 20 || input[0] !== input[0].toUpperCase()){
        etternavn.setAttribute("style", "border-color: red")
        feilEtternavn.style.display = "initial"
    } else{
        etternavn.setAttribute("style", "border-color: green")
        feilEtternavn.style.display = "none"
        validEtternavn = true;
    }
    AllValid();
}
function onChangeMobil(event) {
    const feilMobil = document.getElementById("feilMobil");
    const mobil = document.getElementById('mobil');
    const input = event.target.value;
    if (event.target.value.length != 8 ){
        mobil.setAttribute("style", "border-color: red")
        feilMobil.style.display = "initial";

    } else{
        mobil.setAttribute("style", "border-color: green")
        feilMobil.style.display = "none";
        validMobil = true;
    }
    AllValid();
}
function onChangePassord(event) {
    const passord = document.getElementById('passord');
    const feilPassord = document.getElementById("feilPassord");
    const repetertPassord = document.getElementById("passordRepetert")
    const input = event.target.value;

    if (input.length < 5 ){

            passord.setAttribute("style", "border-color: red")
            feilPassord.style.display = "initial"
        


    } else{
        if (repetertPassord.length > 0){
            if (repetertPassord.value !== input.value){
                passord.setAttribute("style", "border-color: red")
                feilPassord.style.display = "initial"
            }
        }else{
            passord.setAttribute("style", "border-color: green")
            feilPassord.style.display = "none"
            validPassord = true;
        }

    }
    AllValid();
}
function onChangeRepetertPassord(event) {
    const repetertPassord = document.getElementById('passordRepetert');
    const feilRepPassord = document.getElementById("feilRepPassord");
    const passord = document.getElementById('passord')
    const input = event.target.value;
    if (input !== passord.value){ // Sammenligne passord -&& (input.localeCompare(passord)) !== 0
        repetertPassord.setAttribute("style", "border-color: red")
        feilRepPassord.style.display = "initial"
    } else{
        repetertPassord.setAttribute("style", "border-color: green")
        feilRepPassord.style.display = "none"
        validRepPassord = true;
    }
    AllValid();
}
function onChangeKjonn(event) {

    const kjonn = document.getElementById("kjonn");
    const feilKjonn = document.getElementById("feilKjonn");
    const input = event.target.value;
    if (input === null){
        feilKjonn.style.display = "initial"
    }else{
        feilKjonn.style.display = "none"
        validKjonn = true;
    }
    AllValid();
}

function onChangeKjonn1(event) {

    const kjonn1 = document.getElementById("kjonn1");
    const feilKjonn = document.getElementById("feilKjonn");
    const input = event.target.value;
    if (input === null){
        feilKjonn.style.display = "initial"
    }else{
        feilKjonn.style.display = "none"
        validKjonn = true;
    }
    AllValid();
}


function AllValid() {
    if(validRepPassord && validPassord && validMobil && validFornavn && validEtternavn && validKjonn){
        document.getElementById("button").disabled = false;
    }else{
        document.getElementById("button").disabled = true;
    }
}
