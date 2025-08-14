// Get user details
let fullName = prompt("Enter Full Name:");
let panNumber = prompt("Enter PAN Number (10 characters, uppercase):");
let dobInput = prompt("Enter Date of Birth (YYYY-MM-DD):");
let annualIncome = parseFloat(prompt("Enter Annual Income (₹):"));

// Validate PAN
if (panNumber.length !== 10 || panNumber !== panNumber.toUpperCase()) {
    alert("Invalid PAN Number! It must be 10 uppercase characters.");
    throw new Error("Invalid PAN format.");
}

// Calculate age
let dob = new Date(dobInput);
let today = new Date();
let age = today.getFullYear() - dob.getFullYear();
let monthDiff = today.getMonth() - dob.getMonth();
if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
    age--;
}

// Calculate tax
let tax = 0;
if (annualIncome <= 250000) {
    tax = 0;
} else if (annualIncome <= 500000) {
    tax = (annualIncome - 250000) * 0.05;
} else if (annualIncome <= 1000000) {
    tax = (250000 * 0.05) + (annualIncome - 500000) * 0.20;
} else {
    tax = (250000 * 0.05) + (500000 * 0.20) + (annualIncome - 1000000) * 0.30;
}

// Round tax to nearest rupee
tax = Math.round(tax);

// Display result
let output = 
    "Name: " + fullName + "\n" +
    "PAN: " + panNumber + "\n" +
    "Age: " + age + " years\n" +
    "Annual Income: ₹" + annualIncome.toLocaleString() + "\n" +
    "Calculated Tax: ₹" + tax.toLocaleString();

alert(output);
console.log(output);
