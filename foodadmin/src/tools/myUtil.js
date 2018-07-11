import axios from 'axios'

let tempUrl = 'http://localhost:8083'

export const getAllUser = async (restUrl) => {
  let allUsers = []
  return axios.get(tempUrl + restUrl).then((response) => {
    console.log(response)
    allUsers.push(response.data)
    return allUsers
  }).catch((error) => {
    console.log(error)
  })
}

export const deleteUserById = async (id) => {
  return axios.delete(tempUrl + `/deleteById/${id}`).then((response) => {
    return response
  })
}

export const uploadUser = (row) => {
  console.log("updaterow: ", row)
  return axios.put(tempUrl + '/updateUser', row).then((response) => {
    console.log(response)
  })
}
