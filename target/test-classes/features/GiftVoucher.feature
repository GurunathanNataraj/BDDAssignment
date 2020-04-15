Feature: Functionalities of open cart
Scenario: Gift Voucher
Given User is on open cart landing page
When Login
And Go to Gift Voucher and fill details
And Go to shopping cart and remove extra products
And Click on contact us and fill enquiry
And Go to wish list and Edit Account information and Telephone number
And Go to order history and view requests
And Go to modify address book  and edit address
Then ApplicationLogout

