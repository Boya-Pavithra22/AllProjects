const buildingName = "Sunrise Apartments"; 
let status = "OFF"; 
const devices = ["Light", "Fan", "AC"]; 

let result = "";

for (var i = 0; i < devices.length; i++) {
    status = (status === "OFF") ? "ON" : "OFF";

    result += `Checking Switch ${i + 1}: ${devices[i]} is ${status}\n`;
}

result += `All switches checked for ${buildingName}.\n`;
result += `Outside loop: var counter is ${i}\n`;

document.getElementById("output").textContent = result;

try {
    buildingName = "Sunset Villas"; 
} catch (err) {
    console.error("Error:", err.message);
}
