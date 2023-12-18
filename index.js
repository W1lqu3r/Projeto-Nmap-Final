function getPorts(ip, active){
    let  allPortsUrl = `http://localhost:8080/api/all-ports?ipName=${ip}`;
    let  portsByActiveUrl = `http://localhost:8080/api/ports-by-status?ipName=${ip}&active=${active}`;

    if(active == 'all'){
        url = allPortsUrl
    }else{
        url = portsByActiveUrl
    }

    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function limparBusca(){
    inputIpAddress.value = ""
    obj = [];
}

const button = document.getElementById("button");
const inputIpAddress = document.getElementById("inputIpAddress");
const inputPortActive = document.getElementById("inputPortActive");

button.addEventListener("click", function (event) {

    var tableBody = document.getElementById("tableBody");

    let ip = inputIpAddress.value;
    let active = inputPortActive.value;
    
    if(ip == "" ){
        return;
    }
    response = getPorts(ip, active);
    obj = JSON.parse(response);

    console.log(obj)

    if(obj.length == 0 ){
        window.alert(`Não foram encontrados dados sobre a consulta`)
        tableBody.innerHTML = ''
    }else{

    
        tableBody.innerHTML = ''
        obj.forEach(element => {

            var tableRow = document.createElement('tr');

            var rowId = document.createElement('th');
            var rowValor = document.createElement('td');
            var rowStatus = document.createElement('td');   

            rowId.textContent = element.id;
            rowValor.textContent = element.portValue;
            rowStatus.textContent = devolverStatus(element.open);

            tableRow.appendChild(rowId);
            tableRow.appendChild(rowValor);
            tableRow.appendChild(rowStatus);

            tableBody.appendChild(tableRow);
        });
    }
    return;

})

function devolverStatus(valor){
    if(valor == true){
        return "Disponível";
    }else{
        return "Em Uso"
    }
}
