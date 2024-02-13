

async function getDataForMember() {
    let Url = "http://localhost:8080/api/dc/Member";
    try {
        const httprequest = await fetch(Url);
        const requestInJson = await httprequest.json();
        return requestInJson;
    } catch (error) {
        console.error("Fehler bei getDataForMember: ", error);
        return [];
    }
}

async function getDataForAvatarUrl() {
    let Url = "http://localhost:8080/api/dc/MemberAvatarUrl";
    try {
        const httprequest = await fetch(Url);
        const requestInJson = await httprequest.json();
        return requestInJson;
    } catch (error) {
        console.error("Fehler bei getDataForAvatarUrl: ", error);
        return [];
    }
}

async function generateHtml() {
    const userDataContainer = document.getElementById('userData');

    // Daten für Avatar-URLs abrufen
    const avatarUrlData = await getDataForAvatarUrl();

    // Daten für Mitglieder abrufen
    const memberData = await getDataForMember();

    if (userDataContainer.childElementCount === 0) {
        for (const user of memberData) {
            const userId = user.userId;
            const userAvatarData = avatarUrlData.find(item => item.userId === userId);
            let avatarUrl = "";
            const userName = user.Member;

            if(userAvatarData.Avatar === "null"){
                avatarUrl = "/net/sta/webserver/web/img/discordAvatar.png";
            }else{
                avatarUrl = userAvatarData.Avatar;
            }

            userContainer.classList.add('user-box');
            userContainer.innerHTML = `
        <img alt="Profilbild" class="avatar" src="${avatarUrl}">
        <p class="user-id">UserID: ${userId}</p>
        <p class="user-name">Username: ${userName}</p>
        `;

            userDataContainer.appendChild(userContainer);
        }
    }
}

// Daten abrufen und anzeigen

const test = document.getElementById("send");

const testinput = document.getElementById("text");

function kickPersonById() {
    if (!testinput == null){

    }
}
test.addEventListener('click', function () {
    console.log("l");


    fetch('http://localhost:8080/api/dc/KickUser', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            // Weitere Header hier hinzufügen, falls erforderlich
        },
        body: JSON.stringify({
            // Daten, die du senden möchtest
            "test" : testinput,
        }),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Antwort als JSON parsen
        })
        .then(data => {
            console.log('Antwort vom Server:', data);
        })
        .catch(error => {
            console.error('Fetch Error:', error);
        });
});



const userNav = document.getElementById("user");

userNav.addEventListener('click', function(){
    generateHtml();
});


const mainpage = document.getElementById("Admin-dashboard");
mainpage.addEventListener('click', function(){
    const userDataContainer = document.getElementById('userData');
    while (userDataContainer.firstChild) {
        userDataContainer.removeChild(userDataContainer.firstChild);
    }

});


