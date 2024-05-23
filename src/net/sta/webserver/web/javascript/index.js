
const mainpage = document.getElementById("Admin-dashboard");
mainpage.addEventListener('click', function(){
    const userDataContainer = document.getElementById('userData');
    while (userDataContainer.firstChild) {
        userDataContainer.removeChild(userDataContainer.firstChild);
    }
});


async function getDataFromEndpoint(endpointUrl) {
    try {
        const response = await fetch(endpointUrl);
        const data = await response.json();
        return data.map(item => ({ userId: item.userId, Member: item.Member }));
    } catch (error) {
        console.error('Fehler beim Abrufen der Daten:', error);
        return []; // Rückgabe eines leeren Arrays im Fehlerfall
    }
}


function getSuggestions(inputValue) {

    getDataFromEndpoint("http://localhost:8080/api/dc/Member")
        .then(datas => {

            // Filter data based on input value (either name or userId)
            const data = datas
            const filteredData = data.filter(item => {
                return item.Member.toLowerCase().includes(inputValue.toLowerCase()) || item.userId.toLowerCase().includes(inputValue.toLowerCase());
            });

            // Display filtered suggestions
            filteredData.forEach(item => {
                const link = document.createElement("a");
                link.textContent = item.Member + " (" + item.userId + ")";
                link.href = "#"; // We'll handle the click event ourselves
                link.onclick = function() {
                    document.getElementById("userIds").value =  item.Member + "(" + item.userId + ")";
                    suggestionList.innerHTML = ''; // Clear suggestions after selection
                    return false; // Prevent default link behavior
                };
                const li = document.createElement("li");
                li.appendChild(link);
                suggestionList.appendChild(li);
            });
            // Hier können Sie die erhaltenen Daten weiterverarbeiten
        });

    const suggestionList = document.getElementById("suggestionList");
    suggestionList.innerHTML = ''; // Clear previous suggestions


    document.getElementById('userIds').addEventListener('click', function() {

        // Wert der Suchleiste abrufen
        var searchValue = this.value;

        if(searchValue == null || searchValue == ""){
            return;
        }
        // Weiterleitung zu einer Seite mit dem Suchwert als Query-Parameter
        window.location.href = 'https://example.com/search?q=' + encodeURIComponent(searchValue);
    });


}




//Discord admin panel Anmeldung



const LoogedUser = [];

let as = false;

function isAuthenticated() {
    return true;

}

window.onload = function (){
    if (!isAuthenticated()){
        as = true;
        window.location.href='http://localhost:8080/login'
    }else {

    }
}


 async function getDataForLogin() {
    const Url = "http://localhost:8080/data";
    try {
        const httprequest =  await fetch(Url);
        const requestInJson = await httprequest.json();

        console.log(requestInJson)
        return requestInJson;
    } catch (error) {
        console.error("Fehler bei getDataForMember: ", error);
        return [];
    }
}


async function getGlobalNameAndAvatar() {
    try {
        const data = await getDataForLogin(); // Daten abrufen
        if (data && data.length > 0) {
            const firstEntry = data[0]; // Erstes Element aus den Daten
            const globalName = firstEntry.global_name;
            const avatar = firstEntry.avatar;
            const userId = firstEntry.id;
            console.log('Global Name:', globalName);
            console.log('Avatar:', avatar);
            console.log('userid:', userId);

            sayHelloToUser(globalName, avatar, userId);

            // Hier können Sie die erhaltenen Daten weiterverarbeiten
        } else {
            console.error('Keine Daten vorhanden.');
        }
    } catch (error) {
        console.error('Fehler beim Verarbeiten der Daten:', error);
    }
}

// Funktion aufrufen, um die global_name und avatar zu erhalten

getGlobalNameAndAvatar();

function sayHelloToUser(Username, imageId, userid){
    var image = document.getElementById("image");

    var link = "https://cdn.discordapp.com/avatars/" + userid + "/" + imageId + ".png";

    image.src = (link);
}


document.addEventListener("DOMContentLoaded", getOnlineMember)

//window.onload = getOnlineMember();

let online = 0;
let offline = 0;
let idle = 0;
let donotdisturb = 0;

async function getOnlineMember() {
    try {
        const Url = "http://localhost:8080/api/dc/onlineMember";
        const httprequest =  await fetch(Url);
        const requestInJson = await httprequest.json();

        const data = await requestInJson; // Daten abrufen
        if (data && data.length > 0) {
            const firstEntry = data[0]; // Erstes Element aus den Daten
            const  Online = firstEntry.Online;
            const Offline = firstEntry.Offline;
            const Idle = firstEntry.Idle;
            const DoNotDisturb = firstEntry.DoNotDisturb;


            const xValues = ["Online", "Offline", "Idle", "Do Not Disturb"];
            const yValues = [Online,Offline,Idle, DoNotDisturb];
            const barColors = ["darkgreen", "lightgrey","yellow","red"];


            new Chart("myChart", {
                type: "bar",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: barColors,
                        data: yValues
                    }]
                },
                options: {
                    legend: {display: false},
                    title: {
                        display: true,
                        text: "OnlineStatus"
                    }
                }
            });

            console.log('Global Name:', Online);
            console.log('Avatar:', Offline);
            console.log('userid:', Idle);
            console.log('userid:', DoNotDisturb);



            // Hier können Sie die erhaltenen Daten weiterverarbeiten
        } else {
            console.error('Keine Daten vorhanden.');
        }
    } catch (error) {
        console.error('Fehler beim Verarbeiten der Daten:', error);
    }
}

