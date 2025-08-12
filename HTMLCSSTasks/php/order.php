<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    echo "<h2>Order Confirmation</h2>";
    echo "<p><strong>Name:</strong> " . htmlspecialchars($_POST["name"]) . "</p>";
    echo "<p><strong>Email:</strong> " . htmlspecialchars($_POST["email"]) . "</p>";
    echo "<p><strong>Mobile:</strong> " . htmlspecialchars($_POST["mobile"]) . "</p>";
    echo "<p><strong>Address:</strong> " . nl2br(htmlspecialchars($_POST["address"])) . "</p>";

    // Grocery items
    if (!empty($_POST["items"])) {
        echo "<p><strong>Items Ordered:</strong> " . implode(", ", $_POST["items"]) . "</p>";
    } else {
        echo "<p><strong>Items Ordered:</strong> None</p>";
    }

    echo "<p><strong>Quantity:</strong> " . htmlspecialchars($_POST["quantity"]) . "</p>";
    echo "<p><strong>Delivery Date:</strong> " . htmlspecialchars($_POST["date"]) . "</p>";
    echo "<p><strong>Preferred Time:</strong> " . htmlspecialchars($_POST["time"]) . "</p>";
    echo "<p><strong>Payment Method:</strong> " . htmlspecialchars($_POST["payment"]) . "</p>";
    echo "<p><strong>Special Instructions:</strong> " . nl2br(htmlspecialchars($_POST["instructions"])) . "</p>";
    
    echo "<hr>";
    echo "<h3>Thank you! Your order has been received.</h3>";
} else {
    echo "<p>Invalid request. Please submit the form first.</p>";
}
?>
