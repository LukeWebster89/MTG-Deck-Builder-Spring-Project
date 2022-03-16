# MTG-Deck-Builder-Spring-Project

o	Why are we doing this?

o	How I expected the challenge to go.

o	What went well? / What didn't go as planned?

o	Possible improvements for future revisions of the project.

<!DOCTYPE html>
<html>

<head>
	<title>Adding image to dropdown list</title>
	<style>
		.dropbtn {
			background-color: #4CAF50;
			color: white;
			padding: 16px;
			font-size: 16px;
			border: none;
			cursor: pointer;
		}

		.dropdown {
			position: relative;
			display: inline-block;
		}

		.dropdown-content {
			display: none;
			position: absolute;
			background-color: #f9f9f9;
			min-width: 160px;
			box-shadow: 0px 8px 16px
				0px rgba(0, 0, 0, 0.2);
			z-index: 1;
		}

		.dropdown-content a {
			color: black;
			padding: 12px 16px;
			text-decoration: none;
			display: block;
		}

		.dropdown-content a:hover {
			background-color: #f1f1f1
		}

		.dropdown:hover .dropdown-content {
			display: block;
		}

		.dropdown:hover .dropbtn {
			background-color: #3e8e41;
		}
	</style>
</head>

<body>
	<center>
		<h1 style="color: green">
			GeeksforGeeks
		</h1>
		
		<div class="dropdown">
			<button class="dropbtn">
				Country Flags
			</button>
			
			<div class="dropdown-content">
				<a href="#">
					<img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20200630132503/iflag.jpg"
					width="20" height="15"> India</a>

				<a href="#">
					<img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20200630132504/uflag.jpg"
					width="20" height="15"> USA</a>
				<a href="#">
					<img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20200630132502/eflag.jpg"
					width="20" height="15"> England</a>
				<a href="#">
					<img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20200630132500/bflag.jpg"
					width="20" height="15"> Brazil</a>
			</div>
		</div>
	</center>
</body>

</html>


## o Screenshots showing your postman requests and the output from the API.

###Create
![CreatePostman](https://github.com/LukeWebster89/MTG-Deck-Builder-Spring-Project/blob/dev/Documents/Screenshots/APIrequests/CreatePostman.jpg?raw=true) 
  
###Read All
![ReadAllPostman](https://user-images.githubusercontent.com/97948290/158586666-df41285f-bd5e-452c-94b0-4108ffb1d68f.jpg)

###Read By ID
![ReadByIdPostman](https://user-images.githubusercontent.com/97948290/158586703-3f0335e8-ea8d-45bd-b981-e3fe37f772dc.jpg)

###Update
![UpdatePostman](https://user-images.githubusercontent.com/97948290/158586752-03d045e8-9c61-4c07-a6a4-4c79a405eb8c.jpg)

###Delete
![DeletePostman](https://user-images.githubusercontent.com/97948290/158586788-23bd8907-7863-4512-8b83-5e7437ae45e8.jpg)


## o Screenshots of your database to prove that data is being persisted.

<details>
<summary>"Create"</summary>
![CreateMySQL](https://user-images.githubusercontent.com/97948290/158589191-628534b5-13fc-459b-a25a-0bb7788be085.jpg)

</details>

<details>
<summary>"Update"</summary>
![UpdateMySQL](https://user-images.githubusercontent.com/97948290/158589225-e171b01a-d6aa-415d-8a52-1210bf9e4987.jpg)

</details>

<details>
<summary>"Delete"</summary>
![DeleteMySQL](https://user-images.githubusercontent.com/97948290/158589257-b77f1f42-0cd7-4414-a052-7264371f3ff1.jpg)

</details>


## o	Screenshot of your test results, including coverage report.
<details>
<summary>"Overall Coverage"</summary>
![AllTestsCoverage](https://user-images.githubusercontent.com/97948290/158589320-0515b6b0-9f32-4284-ad0c-93d15dd3e5c2.jpg)

</details>

<details>
<summary>"Entity Test"</summary>
![EntityTest](https://user-images.githubusercontent.com/97948290/158589347-543e259c-0779-43d8-8a85-7a2cb7f91517.jpg)

</details>

<details>
<summary>"Controller Test"</summary>
![ControllerTest](https://user-images.githubusercontent.com/97948290/158589379-cfa92595-d3c1-43c8-ad5b-7f424324f78c.jpg)

</details>

<details>
<summary>"Service Test"</summary>
![ServiceUnitTest](https://user-images.githubusercontent.com/97948290/158589403-21a873e5-37cb-4c03-bea2-815e69b4600e.jpg)

</details>

## o	Link to Jira Board - You must add Jordan as collaborators also.

