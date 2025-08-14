function bookTour(event) {
    event.preventDefault(); // Prevent form refresh

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let destination = document.getElementById("destination").value;
    let days = parseInt(document.getElementById("days").value);
    let travelers = parseInt(document.getElementById("travelers").value);

    let pricePerDay = 0;
    if (destination === "Ooty") pricePerDay = 2000;
    else if (destination === "Goa") pricePerDay = 3000;
    else if (destination === "Manali") pricePerDay = 4000;

    alert(destination)

    let totalPrice = pricePerDay * days * travelers;
    alert(totalPrice)
    alert(document.getElementById("summary"))
    document.getElementById("summary").textContent =
        `Name: ${name}\nEmail: ${email}\nDestination: ${destination}\nDays: ${days}\nTravelers: ${travelers}\nTotal Price: ${totalPrice} ₹`;
}
