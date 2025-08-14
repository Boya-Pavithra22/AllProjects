document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("rtoForm");
    const progressBar = document.getElementById("progressBar");
    const submitBtn = document.getElementById("submitBtn");

    const inputs = form.querySelectorAll("input, select, textarea");

    // Simple validation function
    function validateDOB(input) {
        const dob = new Date(input.value);
        const age = new Date().getFullYear() - dob.getFullYear();
        return age > 18 || (age === 18 && new Date() >= new Date(dob.setFullYear(dob.getFullYear() + 18)));
    }

    function updateProgress() {
        let validCount = 0;
        let requiredFields = Array.from(inputs).filter(el => el.hasAttribute("required"));
        requiredFields.forEach(el => {
            if (el.checkValidity()) validCount++;
        });
        const percent = Math.round((validCount / requiredFields.length) * 100);
        progressBar.style.width = percent + "%";
        progressBar.textContent = percent + "%";
        submitBtn.disabled = percent < 100;
    }

    inputs.forEach(input => {
        input.addEventListener("input", () => {
            if (input.id === "dob" && !validateDOB(input)) {
                input.setCustomValidity("Must be 18+ years old.");
            } else {
                input.setCustomValidity("");
            }
            input.classList.toggle("is-valid", input.checkValidity());
            input.classList.toggle("is-invalid", !input.checkValidity());
            updateProgress();
        });
    });

    form.addEventListener("submit", (event) => {
        if (!form.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
        } else {
            event.preventDefault();
            let toast = new bootstrap.Toast(document.getElementById("successToast"));
            toast.show();
            form.reset();
            progressBar.style.width = "0%";
            progressBar.textContent = "0%";
            submitBtn.disabled = true;
        }
        form.classList.add("was-validated");
    });
});
