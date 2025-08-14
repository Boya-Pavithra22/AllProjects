// Closure function to manage portfolio
function createPortfolio() {
    let portfolio = []; // private array

    function buyShare(company, quantity, price) {
        portfolio.push({ company, quantity, price });
        logMessage(`Bought ${quantity} shares of ${company} at ₹${price} each.`);
    }

    function sellShare(company, quantity) {
        let share = portfolio.find(s => s.company === company);
        if (share && share.quantity >= quantity) {
            share.quantity -= quantity;
            logMessage(`Sold ${quantity} shares of ${company}.`);
            if (share.quantity === 0) {
                portfolio = portfolio.filter(s => s.company !== company);
            }
        } else {
            logMessage(`Not enough shares to sell for ${company}.`);
        }
    }

    function totalValue() {
        let total = portfolio.reduce((sum, s) => sum + (s.quantity * s.price), 0);
        logMessage(`Portfolio Value: ₹${total}`);
    }

    // Expose only these functions
    return { buyShare, sellShare, totalValue };
}

// Logger function to display in HTML
function logMessage(message) {
    let logElement = document.getElementById("log");
    logElement.textContent += message + "\n";
}

// Create portfolio instance
const myPortfolio = createPortfolio();

// Example buttons calling closure methods
function buyTCS() {
    myPortfolio.buyShare("TCS", 10, 3500);
}

function buyInfosys() {
    myPortfolio.buyShare("Infosys", 5, 1500);
}

function sellTCS() {
    myPortfolio.sellShare("TCS", 3);
}

function showValue() {
    myPortfolio.totalValue();
}
