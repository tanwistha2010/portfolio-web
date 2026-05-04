function validateContactForm() {
    const name = document.getElementById('contact-name').value.trim();
    const email = document.getElementById('contact-email').value.trim();
    const message = document.getElementById('contact-message').value.trim();
    const errorBox = document.getElementById('contact-error');

    let error = '';

    if (name.length < 2) {
        error = 'Name should have at least 2 characters.';
    } else if (!/^\S+@\S+\.\S+$/.test(email)) {
        error = 'Enter a valid email address.';
    } else if (message.length < 10) {
        error = 'Message should be at least 10 characters.';
    }

    if (error) {
        errorBox.textContent = error;
        errorBox.style.display = 'block';
        return false;
    }

    errorBox.style.display = 'none';
    return true;
}

function toggleTheme() {
    const body = document.body;
    const themeButton = document.getElementById('theme-button');

    body.classList.toggle('dark');

    const currentTheme = body.classList.contains('dark') ? 'dark' : 'light';
    localStorage.setItem('portfolioTheme', currentTheme);

    if (themeButton) {
        themeButton.textContent = currentTheme === 'dark' ? 'Light Mode' : 'Dark Mode';
    }
}

function loadTheme() {
    const savedTheme = localStorage.getItem('portfolioTheme');
    const themeButton = document.getElementById('theme-button');

    if (savedTheme === 'dark') {
        document.body.classList.add('dark');
        if (themeButton) {
            themeButton.textContent = 'Light Mode';
        }
    } else {
        document.body.classList.remove('dark');
        if (themeButton) {
            themeButton.textContent = 'Dark Mode';
        }
    }
}

window.addEventListener('DOMContentLoaded', function () {
    loadTheme();
});
