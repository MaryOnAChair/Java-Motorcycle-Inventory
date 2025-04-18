# - Part C  


Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts. 



---

- File Name:confirmationaddproduct.html
- Line Number: 10
- Change: changed product to motorcycle

-

- File Name:confirmationdeleteproduct.html
- Line Number:10
- Change:changed product to motorcycle

-

- File Name:InhousePartForm.html
- Line Number:10
- Change:"Inhouse" to "OEM"

-

- File Name:negativeerror.html
- Line Number:8
- Change:"product" to "motorcycle"

-

- File Name: OutsourcedPartForm.html
- Line Number:10
- Change:"Outsourced" to "Aftermarket"
 
-

- File Name:productForm.html
- Line Number:12
- Change:"product" to "motorcycle"

-

- File Name:saveproductscreen.html
- Line Number:8
- Change:"product" to "motorcycle"

-

- File Name:
	- Line Number:14-20
		- Change:Changed title and added css
	- Line Number: 25-26
		- Change:changed heading and added image
	- Line Number:37-38
		- Change:Chnaged button names
	- Line Number:60
		- Change:"products" to "motorcycles"
	- Line Number:74
		- Change:"product" to "motorcycle"
 ---
#- Part D

Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

---

- File Name: about.html
- Line Number:1-95
- Change: added about page

-

- File Name: aboutController.java
- Line Number:1-13
- Change: added controller for about page

-

- File Name: mainscreen.html
- Line Number: 20-30
- Change: added style to link to about page

- File Name: mainscreen.html
- Line Number: 39-40
- Change: added link to about page

-

- File Name: hondarr.jpg/motoMain.jpg/purple1.jpg/purple2.jpg
- Line Number: n/a
- Change: Added images


---

#- Part E
-
Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

---

- File Name: BootStrapData.java
- Line Number: 47 -110
- Change: Added products and parts to sample inventory

-

- File Name: BootStrapData.java
- Line Number: 3/7/35/41
- Change: Imports for outsourced and inhouse parts

-

-  File Name: application.properties
- Line Number: 6
- Change: Edited database url


---
 
#- Part F

Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:

- The “Buy Now” button must be next to the buttons that update and delete products.
- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
- Display a message that indicates the success or failure of a purchase.
 
---

- File Name:
- Line Number:
- Change:

---

#- Part G

Modify the parts to track maximum and minimum inventory by doing the following:

- Add additional fields to the part entity for maximum and minimum inventory.

- Modify the sample inventory to include the maximum and minimum fields.

- Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.

- Rename the file the persistent storage is saved to.
- Modify the code to enforce that the inventory is between or at the minimum and maximum value.

---
- File Name:
- Line Number:
- Change:

---
#- Part H
Add validation for between or at the maximum and minimum fields. The validation must include the following:

- Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.

- Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.

- Display error messages when adding and updating parts if the inventory is greater than the maximum.
 
---
- File Name:
- Line Number:
- Change:

---

#- Part I

  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

- File Name:
- Line Number:
- Change:

---
#- Part J
Remove the class files for any unused validators in order to clean your code.

- File Name:
- Line Number:
- Change:

