// Step 1: Welcome alert
alert("Welcome to the Quiz Game!");

// Step 2: Ask name using prompt
let userName = prompt("What's your name?");

// Step 3: Confirm if ready
let ready = confirm(userName + ", are you ready for the quiz?");

// Step 4 & 5: Quiz Question
if (ready) {
    let answer = prompt(
        "Question: What is the capital of India?\n" +
        "a) Mumbai\n" +
        "b) New Delhi\n" +
        "c) Kolkata"
    );

    if (answer.toLowerCase() === "b" || answer.toLowerCase() === "new delhi") {
        alert("✅ Correct! Well done, " + userName + "!");
    } else {
        alert("❌ Wrong! The correct answer is New Delhi.");
    }
} else {
    alert("Okay " + userName + ", come back when you are ready!");
}
