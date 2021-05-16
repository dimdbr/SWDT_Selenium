Feature: Epam testing

  Scenario: Clicking SERVICE buttons on header
    Given main page of epam.com
    When click on button on header with SERVICES text
    Then redirecting to services webpage

  Scenario: Hover check
    Given main page of epam.com
    When finding web element with class rollover_tiles__image and bulb picture and hover mouse on it
    Then pop-up element with class rollover_tiles__description and text CONSULT

  Scenario: Clicking on slides navigation panel
    Given main page of epam.com
    When find on page slider block and click on web element on slider block with class slider__dot
    Then slider content is clickable

  Scenario: Changing region and language panel pop-up
    Given main page of epam.com
    When find element on header with class location_selector__button and click on found element
    Then element with class location_selector_panel pop-up

  Scenario: Clicking button to change region and language to Ukraine
    Given main page of epam.com
    When click on button with text Ukraine Українська
    Then redirect to careers.epam.ua

  Scenario:Sending form from Contact Us page
    Given page epam.com/about/who-we-are/contact
    When fill all required fields and select checkboxes and press submit button
    Then form will be successfully submitted

  Scenario: Submitting uncompleted form
    Given page epam.com/about/who-we-are/contact
    When dont complete form
    Then field borders become red and appear hints to complete required fields


  Scenario: Searching for nonsense string on search line
    Given main page of epam.com
    When click on button with magnifier glass icon on it and fill text box with "qwertyuiop" and make a request
    Then expect line with text "Sorry, but your search returned no results. Please tray another query"