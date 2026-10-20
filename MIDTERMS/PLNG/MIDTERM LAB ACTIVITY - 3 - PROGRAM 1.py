text = "Hello Python"
bytes_obj = text.encode("utf-8")
obj_bytes = bytes_obj.decode("utf-8")
bytes_hex = bytes_obj.hex()
hex_bytes = bytes.fromhex(bytes_hex)
byte_array_obj = bytearray(text, "utf-8")
byte_array = bytearray(bytes_obj)
bytes_obj_split = bytes_obj.split()[0]
byte_array_full = bytearray(bytes_obj)
byte_array_full[0] = ord('h')
result = byte_array_full.decode('utf-8')

print(f'{bytes_obj}\n{obj_bytes}\n{bytes_hex}\n{hex_bytes}\n{byte_array_obj}\n{byte_array}\n{bytes_obj_split}\n{result}')
