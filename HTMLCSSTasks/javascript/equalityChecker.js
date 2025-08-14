// Get inputs from user
let value1 = prompt("Enter the first value:");
let value2 = prompt("Enter the second value:");

// Try converting second value to number for demonstration
let numValue1 = Number(value1);
let numValue2 = Number(value2);

// Detect and store types
let type1 = typeof value1;
let type2 = typeof value2;

// Since prompt always returns strings, let's show both string and number comparisons
let output = `First Value: ${value1} (${type1})\n` +
             `Second Value: ${value2} (${type2})\n\n`;

// Comparison using == (loose equality)
let looseEquality = (value1 == value2);
output += `Using == : ${looseEquality} → Equality ignores type\n`;

// Comparison using === (strict equality)
let strictEquality = (value1 === value2);
output += `Using === : ${strictEquality} → Strict equality checks type too\n`;

// Comparison using != (loose inequality)
let looseInequality = (value1 != value2);
output += `Using != : ${looseInequality} → Values considered unequal if loose equality fails\n`;

// Comparison using !== (strict inequality)
let strictInequality = (value1 !== value2);
output += `Using !== : ${strictInequality} → Strict inequality checks type and value\n`;

// Show type conversion example
output += `\nType Conversion Example:\n`;
output += `First Value as Number: ${numValue1} (${typeof numValue1})\n`;
output += `Second Value as Number: ${numValue2} (${typeof numValue2})\n`;

// Show result
alert(output);
console.log(output);
