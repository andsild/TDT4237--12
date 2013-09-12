#/bin/sh

ROOT="${HOME}/Dropbox/Progsik/Filesearch OWASP_CM_OO5/"
echo "$ROOT"

for filename in "$(cat ${ROOT}/filenames.txt)"
do
	echo $filename
done
	

# EOF 
