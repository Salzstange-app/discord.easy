async function getDataForMember() {
    let Url = "http://localhost:8080/api/dc/Member";
    try {
        const httprequest = await fetch(Url);
        return await httprequest.json();
    } catch (error) {
        console.error("Fehler bei getDataForMember: ", error);
        return [];
    }
}

async function getDataForAvatarUrl() {
    let Url = "http://localhost:8080/api/dc/MemberAvatarUrl";
    try {
        const httprequest = await fetch(Url);
        return await httprequest.json();
    } catch (error) {
        console.error("Fehler bei getDataForAvatarUrl: ", error);
        return [];
    }
}

async function generateHtml() {
    const userDataContainer = document.querySelector(".user-container");
    console.log(userDataContainer);

    // Daten für Avatar-URLs abrufen
    const avatarUrlData = await getDataForAvatarUrl();

    // Daten für Mitglieder abrufen
    const memberData = await getDataForMember();


    if (userDataContainer) {
        for (const user of memberData) {
            const userId = user.userId;
            const userAvatarData = avatarUrlData.find(item => item.userId === userId);
            let avatarUrl = "";
            const userName = user.Member;

            if (userAvatarData && userAvatarData.Avatar !== "null") {
                avatarUrl = userAvatarData.Avatar;
            } else {
                avatarUrl = "/net/sta/webserver/web/img/discordAvatar.png";
            }

            const userInfo = document.createElement("div");
            userInfo.classList.add("user-info");
            userInfo.innerHTML = `
                <img alt="Profilbild" class="avatar" src="${avatarUrl}">
                <p class="user-id">UserID: ${userId}</p>
                <p class="user-name">Username: ${userName}</p>
            `;
            userDataContainer.appendChild(userInfo);
        }
    } else {
        console.log("Kein Element mit der Klasse 'user-container' gefunden.");
    }
}
window.onload = function (){
    generateHtml();
}