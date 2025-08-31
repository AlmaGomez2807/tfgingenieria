function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
    return null;
}

function enviar(URL, jsonAEnviar, metodo){
    fetch(URL, {
        method: metodo,
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonAEnviar
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        }
        throw new Error('Network response was not ok.');
    })
    .then(data => {
        console.log('Response from server:', data);
        // Perform actions with the response data as needed
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
}