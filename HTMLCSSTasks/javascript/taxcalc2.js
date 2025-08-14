let taxRecords = [];

function calculateTax(name, pan, income, callback) {
    let tax = 0;

    if (income <= 250000) {
        tax = 0;
    } else if (income <= 500000) {
        tax = (income - 250000) * 0.05;
    } else if (income <= 1000000) {
        tax = (250000 * 0.05) + (income - 500000) * 0.2;
    } else {
        tax = (250000 * 0.05) + (500000 * 0.2) + (income - 1000000) * 0.3;
    }

    callback(name, pan, income, tax);
}

function logToConsole(name, pan, income, tax) {
    console.log(`Name: ${name}, PAN: ${pan}, Income: ₹${income}, Tax: ₹${tax}`);
}

function displayOnPage(name, pan, income, tax) {
    document.getElementById("output").textContent =
        `Name: ${name}\nPAN: ${pan}\nIncome: ₹${income}\nTax: ₹${tax}`;
}

function saveToRecords(name, pan, income, tax) {
    taxRecords.push({ name, pan, income, tax });
    console.log("Tax Records:", taxRecords);
}

function calculate() {
    const name = document.getElementById("name").value;
    const pan = document.getElementById("pan").value;
    const income = parseFloat(document.getElementById("income").value);

    if (!name || !pan || isNaN(income)) {
        alert("Please fill all fields correctly.");
        return;
    }

    calculateTax(name, pan, income, (n, p, i, t) => {
        logToConsole(n, p, i, t);
        displayOnPage(n, p, i, t);
        saveToRecords(n, p, i, t);
    });
}
