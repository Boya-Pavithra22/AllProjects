let books = [
    { title: "JavaScript Basics", author: "Anu", price: 450, available: true },
    { title: "HTML & CSS", author: "Devi", price: 350, available: false }
];

console.log("All Books:");
for (let book of books) {
    console.log(`Title: ${book.title}, Author: ${book.author}, Price: ${book.price}, Available: ${book.available} ₹`);
}

console.log("Available Books:");
for (let book of books) {
    if (book.available) {
        console.log(`Title: ${book.title}, Author: ${book.author}, Price: ${book.price} ₹`);
    }
}

books.push({ title: "Node.js Guide", author: "Kiran", price: 600, available: true });
console.log("After Adding");
console.log(books.map(b => b.title).join(", "));

books[0].price = 500;
console.log("After Price Update:");
console.log(`${books[0].title} - ${books[0].price} ₹`);

books.splice(0, 1);
console.log("After Deletion:");
console.log(books.map(b => b.title).join(", "));
