from linkedin import linkedin

API_KEY = ''
API_SECRET = ''
RETURN_URL = 'https://diljotsg.com/'

authentication = linkedin.LinkedInAuthentication(API_KEY, API_SECRET, RETURN_URL)
print authentication.authorization_url  # open this url on your browser
application = linkedin.LinkedInApplication(authentication)

application.get_profile()