
const button = document.getElementById("Tickets");

button.addEventListener('click', function(){
    console.log("tets")
    var chartContainer = document.querySelector('.chart-container');
    var topRight = document.querySelector('.top-right');

    // Lösche den Inhalt der Elemente
    chartContainer.innerHTML = '';
    topRight.innerHTML = '';




    const ticketData = {
        "ticket-test": [
            {"id": 1215201017654673448, "author": "652033110099361802", "content": "g"},
            {"id": 1215201016123891722, "author": "652033110099361802", "content": "g"},
            {"id": 1215201016123891722, "author": "652033110099361802", "content": "g"},
            {"id": 1215201016123891722, "author": "652033110099361802", "content": "g"},
            {"id": 1215201016123891722, "author": "652033110099361802", "content": "g"},
            {"id": 1215201016123891722, "author": "652033110099361802", "content": "g"},
            {"id": 1215201016123891722, "author": "652033110099361802", "content": "g"},


            // Weitere Nachrichten hier...
        ]
    };

// Umkehren der Reihenfolge der Nachrichten
    const reversedTickets = ticketData['ticket-test'].reverse();

// Element, in dem die Nachrichten angezeigt werden sollen
    const ticketContainer = document.getElementById('ticket-container');

// Nachrichten in das HTML einfügen
    reversedTickets.forEach(ticket => {
        const messageElement = document.createElement('div');
        messageElement.textContent = `Author: ${ticket.author}, Content: ${ticket.content}`;
        ticketContainer.appendChild(messageElement);
    });

});