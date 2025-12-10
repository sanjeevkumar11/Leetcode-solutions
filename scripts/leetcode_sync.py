import requests
import json
import os

LEETCODE_SESSION = os.getenv("LEETCODE_SESSION")
CSRF_TOKEN = os.getenv("LEETCODE_CSRF")

cookies = {
    "LEETCODE_SESSION": LEETCODE_SESSION,
    "csrftoken": CSRF_TOKEN
}

headers = {
    "x-csrftoken": CSRF_TOKEN,
    "user-agent": "Mozilla/5.0"
}

# List all submissions
def get_submissions():
    url = "https://leetcode.com/api/submissions/"
    r = requests.get(url, cookies=cookies, headers=headers)
    return r.json()

# Save each accepted submission in solutions/
def save_solutions():
    data = get_submissions()

    if not os.path.exists("solutions"):
        os.makedirs("solutions")

    for sub in data.get("submissions_dump", []):
        if sub["status_display"] != "Accepted":
            continue

        title = sub["title"].replace(" ", "_")
        lang = sub["lang"]

        ext = {
            "python3": "py",
            "cpp": "cpp",
            "java": "java",
            "javascript": "js"
        }.get(lang, "txt")

        filename = f"solutions/{title}.{ext}"

        with open(filename, "w", encoding="utf-8") as f:
            f.write(sub["code"])

        print("Saved:", filename)


if __name__ == "__main__":
    save_solutions()
