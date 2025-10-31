package dev.datlag.kommons


data object Lebanon : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("LB")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("LBN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(422)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(961)
    override val continent: Continent = Continent.Asia
}