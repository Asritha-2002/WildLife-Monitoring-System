function submitForm(event) {
    event.preventDefault(); // Prevent default form submission

    // Get form data
    const form = document.getElementById('registrationForm');
    const formData = new FormData(form);

    // Convert form data to JSON object
    const jsonObject = {};
    formData.forEach((value, key) => {
        jsonObject[key] = value;
    });

    console.log('Form Data:', jsonObject); // Log form data for debugging

    // Send AJAX request to your backend
    fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(jsonObject),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Response Data:', data); // Log response data for debugging
            if (data.id) {
                document.getElementById('message').textContent = 'Registration successful!';
                form.reset(); // Reset form after successful submission
            } else {
                document.getElementById('message').textContent = 'Registration failed. Please try again later.';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('message').textContent = 'Error occurred. Please try again later.';
        });
}
