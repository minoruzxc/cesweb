function checkIfEmpty(){
    let inputValue = document.getElementById('nomeInputField').value;

    if (inputValue === ""){
        document.getElementById("botaoCadastrar").disabled = true;
    }else if (!inputValue == ""){
        document.getElementById("botaoCadastrar").disabled = false;
    }
}

function javaTest(){
    alert('hello world')
}