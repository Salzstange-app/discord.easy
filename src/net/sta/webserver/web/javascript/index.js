

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

            const userContainer = document.createElement('div');
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


