package dev.datlag.kommons


data object Netherlands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NL")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NLD")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(528)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(31)
    override val continent: Continent = Continent.Europe
}