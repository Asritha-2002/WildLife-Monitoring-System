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

    console.log('Form Data:', jsonObject); // Log form data

    // Send AJAX request to your backend
    fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(jsonObject),
    })
        .then(response => {
            console.log('Response:', response); // Log response
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            console.log('Data:', data); // Log response data
            document.getElementById('message').textContent = data;
            form.reset(); // Reset form after successful submission
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('message').textContent = 'Error occurred. Please try again later.';
        });
}
