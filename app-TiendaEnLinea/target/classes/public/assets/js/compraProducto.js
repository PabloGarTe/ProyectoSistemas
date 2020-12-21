var bLogeo = document.getElementById('compra');
bLogeo.addEventListener('click', function () {
    var e = document.getElementById('numTarjeta').value;
    var p = document.getElementById('codigoSeguridad').value;
    const parametros = new URLSearchParams();
    parametros.append('numTarjeta', e);
    parametros.append('codigoSeguridad', p);
    // axios.get('http://localhost/hola?'+parametros)
    //     .then(function (response) {
    //         console.log(response)
    //         console.log('contenido: ' + response.data)
    //         console.log('estatus: ' + response.status)
    //         document.getElementById('titulo').innerHTML = response.data
    //     })
    //     .catch(function (error) {
    //         console.log(error)
    //     })
    axios.post('http://localhost/compraForm?'+parametros)
        .then(function (response) {
            console.log(response)
            console.log('contenido: ' + response.data)
            console.log('estatus: ' + response.status)
            var mensaje=innerHTML = response.data
            alert(mensaje)//.innerHTML = response.data
            location.href ="/";
        })
        .catch(function (error) {
            console.log(error)
        })
})