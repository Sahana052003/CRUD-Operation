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

    <form action="updateData" method="post">

        <!-- ID -->
        <div class="mb-3">
            <label>ID</label>
            <input type="number" class="form-control" id="id" name="id" value="${info.id}" readonly>
            <div id="idError" class="error"></div>
        </div>

        <!-- Name -->
        <div class="mb-3">
            <label>Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${info.name}" readonly>
            <div id="nameError" class="error"></div>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label>Email</label>
            <input type="text" class="form-control" id="email" name="email" value="${info.email}">
            <div id="emailError" class="error"></div>
        </div>

        <!-- Address -->
        <div class="mb-3">
            <label>Address</label>
            <textarea class="form-control" id="address" name="address">${info.address}</textarea>
            <div id="addressError" class="error"></div>
        </div>

        <!-- Phone -->
        <div class="mb-3">
            <label>Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${info.phoneNumber}">
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
                <option >${info.state}</option>
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
                <option>${info.country}</option>
                <option>India</option>
                <option>Japan</option>
                <option>South Korea</option>
                <option>Canada</option>
                <option>UK</option>
            </select>
            <div id="countryError" class="error"></div>
        </div>

    </form>

    </body>
    </html>