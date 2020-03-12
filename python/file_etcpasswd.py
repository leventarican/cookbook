# parse etc/passwd
users = {}
with open('/etc/passwd') as f:
    for line in f:
        user_info = line.split(":")
        users[user_info[0]] = user_info[2]

for user_name, user_id in sorted(users.items()):
    print(f"{user_name}: {user_id}")
