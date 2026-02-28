<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>

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

    <h3 class="text-center mb-4 text-primary">User Registration</h3>

    <p style="color:green">${message}</p>
    <p style="color:red">${errormsg}</p>

    <form action="register" method="post" onsubmit="return validateForm()">

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

        <!-- Address -->
        <div class="mb-3">
            <label>Address</label>
            <textarea class="form-control" id="address" name="address"></textarea>
            <div id="addressError" class="error"></div>
        </div>

        <!-- Phone -->
        <div class="mb-3">
            <label>Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
            <div id="phoneNumberError" class="error"></div>
        </div>

        <!-- Gender -->
        <div class="mb-3">
            <label>Gender</label><br>
            <input type="radio" name="gender" value="Male"> Male
            <input type="radio" name="gender" value="Female"> Female
            <input type="radio" name="gender" value="Other"> Other
            <div id="genderError" class="error"></div>
        </div>

        <!-- State -->
        <div class="mb-3">
            <label>State</label>
            <select class="form-select" id="state" name="state">
                <option value="">Select State</option>
                <option>Telangana</option>
                <option>Andhra Pradesh</option>
                <option>Karnataka</option>
                <option>Tamil Nadu</option>
                <option>Maharashtra</option>
            </select>
            <div id="stateError" class="error"></div>
        </div>

        <!-- Country -->
        <div class="mb-3">
            <label>Country</label>
            <select class="form-select" id="country" name="country">
                <option value="">Select Country</option>
                <option>India</option>
                <option>Japan</option>
                <option>South Korea</option>
                <option>Canada</option>
                <option>UK</option>
            </select>
            <div id="countryError" class="error"></div>
        </div>

        <button type="submit" class="btn btn-primary w-100">
            Submit
        </button>

    </form>

<a href="getUserDetails" class="btn btn-success w-100">Get Data</a>
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
            if (!/^[^ ]+@[^ ]+\.[a-z]{2,3}$/.test(value))
                showError('email','emailError','Enter valid email');
            else showSuccess('email');
            break;

        case 'address':
            if (value.length < 5)
                showError('address','addressError','Address too short');
            else showSuccess('address');
            break;

        case 'phoneNumber':
            if (!/^[0-9]{10}$/.test(value))
                showError('phoneNumber','phoneNumberError','Enter 10 digit number');
            else showSuccess('phoneNumber');
            break;

       case 'state':
           if (value === '')
               showError('state','stateError','Select state');
           else showSuccess('state');
           break;

       case 'country':
           if (value === '')
               showError('country','countryError','Select country');
           else showSuccess('country');
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
    input.classList.add('error-border');
    input.classList.remove('success-border');
    document.getElementById(errorId).innerText = message;
}

function showSuccess(inputId) {
    const input = document.getElementById(inputId);
    input.classList.remove('error-border');
    input.classList.add('success-border');
    document.getElementById(inputId+'Error').innerText = "";
}

ddocument.querySelectorAll('input[type="text"], textarea')
 .forEach(input => {
     input.addEventListener('input', () => validateField(input.id));
 });

 document.querySelectorAll('select')
 .forEach(select => {
     select.addEventListener('change', () => validateField(select.id));
 });
function validateForm() {

    let valid = true;

    ['name','email','address','phoneNumber','state','country']
    .forEach(id => {
        validateField(id);
        if(document.getElementById(id).classList.contains('error-border'))
            valid = false;
    });

    if(!validateGender())
        valid = false;

    return valid;
}

</script>

</body>
</html>