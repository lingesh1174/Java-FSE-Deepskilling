import axios from "axios";
import GitClient from "./GitClient";
jest.mock('axios');

describe("Git Client Tests", ()=>{

    test("should return repository names for techiesyed", async ()=>{
        const dummyData = {
        data: [
            { name: "repo1" },
            { name: "repo2" },
            { name: "repo3" }
        ]
        };

        axios.get.mockResolvedValue(dummyData);

        const response = await GitClient.getRepositories("techiesyed");

        expect(axios.get).toHaveBeenCalledWith("https://api.github.com/users/techiesyed/repos");
        expect(response.data).toEqual(dummyData.data);
    });
})