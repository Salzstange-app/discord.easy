
function sendBanData() {

    var UserId = document.getElementById("userIds");
    var reason = document.getElementById("reason");

        fetch('http://localhost:8080/api/dc/BanUser', {
            method: 'POST',
            body: UserId.value + "-" + (reason.value !== "" ? reason.value : "No Reason"),

        }).then(response => response.json())
            .then(data => {
                console.log('Antwort vom Server:', data);
            })
            .catch(error => {
                console.error('Fehler beim Senden der Daten:', error);
            });
}
