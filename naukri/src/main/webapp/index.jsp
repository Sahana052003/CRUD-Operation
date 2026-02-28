<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background: #f0f2f5;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-box {
            background: white;
            padding: 30px;
            width: 450px;
            border-radius: 10px;
            box-shadow: 0px 4px 20px rgba(0,0,0,0.1);
        }

        .error {
            color: red;
            font-size: 13px;
        }

        .error-border {
            border: 2px solid red !important;
        }

        .success-border {
            border: 2px solid green !important;
        }
    </style>
</head>

<body>

<div class="form-box">

    <h3 class="text-center mb-4 text-primary">User Login</h3>


<p style="color:green">${message}</p>
<p style="color:red">${errormsg}</p>


    <form action="login" method="post" onsubmit="return validateForm()">

        <!-- Name -->
        <div class="mb-3">
            <label>Name</label>
            <input type="text" class="form-control" id="name" name="name">
            <div id="nameError" class="error"></div>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label>Email</label>
            <input type="text" class="form-control" id="email" name="email">
            <div id="emailError" class="error"></div>
        </div>

        <!-- Mobile -->
        <div class="mb-3">
            <label>Mobile Number</label>
            <input type="text" class="form-control" id="mobileNumber" name="mobileNumber">
            <div id="mobileNumberError" class="error"></div>
        </div>

        <!-- Location -->
        <div class="mb-3">
            <label>Location</label>
            <input type="text" class="form-control" id="location" name="location">
            <div id="locationError" class="error"></div>
        </div>

        <!-- Gender -->
        <div class="mb-3">
            <label>Gender</label><br>
            <input type="radio" name="gender" value="Male"> Male
            <input type="radio" name="gender" value="Female"> Female
            <input type="radio" name="gender" value="Other"> Other
            <div id="genderError" class="error"></div>
        </div>

        <!-- Nationality -->
        <div class="mb-3">
            <label>Nationality</label>
            <select class="form-select" id="nationality" name="nationality">
                <option value="">Select Nationality</option>
                <option>Indian</option>
                <option>South Korea</option>
                <option>Japan</option>
                <option>Canadian</option>
                <option>UK</option>
            </select>
            <div id="nationalityError" class="error"></div>
        </div>

        <button type="submit" class="btn btn-primary w-100">
            Submit
        </button>

    </form>
 <a href="getDetails" class="btn btn-success w-100">Get Data</a>
</div>

<script>

function validateField(id) {
    const value = document.getElementById(id)?.value.trim();

    switch(id) {

        case 'name':
            if (!/^[A-Za-z ]{3,}$/.test(value))
                showError('name','nameError','Minimum 3 letters required');
            else showSuccess('name');
            break;

        case 'email':
            if (!/^[A-Za-z0-9._%+-]+@gmail\.com$/.test(value))
                showError('email','emailError','Enter valid Gmail');
            else showSuccess('email');
            break;

        case 'mobileNumber':
            if (!/^[6-9]\d{9}$/.test(value))
                showError('mobileNumber','mobileNumberError','Invalid mobile number');
            else showSuccess('mobileNumber');
            break;

        case 'location':
            if (value === '')
                showError('location','locationError','Location required');
            else showSuccess('location');
            break;

        case 'nationality':
            if (value === '')
                showError('nationality','nationalityError','Select nationality');
            else showSuccess('nationality');
            break;
    }
}

function validateGender() {
    const gender = document.querySelector('input[name="gender"]:checked');
    if (!gender) {
        document.getElementById("genderError").innerText = "Select gender";
        return false;
    } else {
        document.getElementById("genderError").innerText = "";
        return true;
    }
}

function showError(inputId, errorId, message) {
    const input = document.getElementById(inputId);
    if(input){
        input.classList.add('error-border');
        input.classList.remove('success-border');
    }
    document.getElementById(errorId).innerText = message;
}

function showSuccess(inputId) {
    const input = document.getElementById(inputId);
    if(input){
        input.classList.remove('error-border');
        input.classList.add('success-border');
    }
    const error = document.getElementById(inputId+'Error');
    if(error) error.innerText = "";
}

document.querySelectorAll('input, select')
.forEach(input => {
    input.addEventListener('input', () => validateField(input.id));
});

function validateForm() {

    let valid = true;

    ['name','email','mobileNumber','location','nationality']
    .forEach(id => {
        validateField(id);
        if(document.getElementById(id)
        .classList.contains('error-border'))
        valid = false;
    });

    if(!validateGender())
        valid = false;

    return valid;
}

</script>

</body>
</html>