

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

