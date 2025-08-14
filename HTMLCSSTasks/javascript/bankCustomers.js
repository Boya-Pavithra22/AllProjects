let numCustomers = parseInt(prompt("Enter the number of customers to register:"));
let customers = [];

for (let i = 0; i < numCustomers; i++) {
    let name = prompt(`Enter the name of customer ${i + 1}:`);
    customers.push(name);
}

console.log("Original Customers: " + customers.join(", "));

console.log("Customers using for...of:");
for (let name of customers) {
    console.log(name);
}

console.log("Customer IDs using for...in:");
for (let index in customers) {
    console.log(index);
}

customers.push("Anita");
console.log("After push('Anita'): " + customers.join(", "));

customers.pop();
console.log("After pop(): " + customers.join(", "));

customers.splice(1, 0, "Vikram");
console.log("After insert 'Vikram' at position 1: " + customers.join(", "));

customers.splice(2, 1);
console.log("After delete at position 2: " + customers.join(", "));

console.log("Final Customers: " + customers.join(", "));
